package com.tomas.zomato.home

import com.tomas.zomato.home.interfaces.MainViewInterface
import com.tomas.zomato.home.models.City
import io.mockk.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private lateinit var presenter: MainPresenter
    private val citiesSlot = slot<List<City>>()

    private val view = mockk<MainViewInterface> {
        every { showCities(capture(citiesSlot)) } just Runs
    }

    private val city = City(123, "title", 132.1, 133.1, "US")


    @Before
    fun setup() {
        presenter = MainPresenter(view)
    }

    @Test
    fun `test showCities empty list `() {
        presenter.showCities(emptyList())
        val list = citiesSlot.captured
        assertEquals(0, list.size)
    }

    @Test
    fun `test showCities valid list`() {
        presenter.showCities(listOf(city))
        val list = citiesSlot.captured
        assertEquals(123, list.first().entity_id)
    }

    @Test
    fun `test showCities full name`() {
        presenter.showCities(listOf(city))
        val list = citiesSlot.captured
        assertEquals("title, US", list.first().fullName)
    }
}