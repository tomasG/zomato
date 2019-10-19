package com.tomas.zomato.utils

import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.location.LocationManager
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest

class LocationManager(
    val context: Context,
    val locationCallback: LocationCallback
) {

    private var locationManager: LocationManager = context.getSystemService(LOCATION_SERVICE) as LocationManager

    init {
        //locationManager.requestLocationUpdates(getLocationRequest(), locationCallback, null)

    }

    private fun getLocationRequest(): LocationRequest {
        return LocationRequest().apply {
            interval = 5000L
            fastestInterval = 1000L
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }
}