package com.example.homework300819.models

import com.google.gson.annotations.SerializedName



data class Source (

	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String
)