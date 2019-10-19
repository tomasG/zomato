package com.tomas.zomato.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tomas.zomato.R
import com.tomas.zomato.home.interfaces.MainViewInterface
import com.tomas.zomato.home.models.City
import com.tomas.zomato.home.models.SuggestedAdapter
import com.tomas.zomato.core.DataHolder
import com.tomas.zomato.core.Router
import com.tomas.zomato.utils.hideKeyboard
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainViewInterface, KoinComponent {

    private val presenter by inject<MainPresenter> { parametersOf(this) }
    private val dataHolder by inject<DataHolder>()
    private val router by inject<Router>()
    private val suggestedAdapter = SuggestedAdapter(view = this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        locationEditText.doAfterTextChanged {
            presenter.getCities(it.toString())
        }
        locationRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = suggestedAdapter
        }
    }

    override fun showCities(citiesList: List<City>) {
        if (citiesList.isNotEmpty()) {
            locationRecyclerView.hideKeyboard()
            with(suggestedAdapter) {
                list = citiesList
                notifyDataSetChanged()
            }
        }
    }

    override fun onCityClicked(city: City) {
        dataHolder.city = city
        router.openRestaurants(this@MainActivity)
    }
}
