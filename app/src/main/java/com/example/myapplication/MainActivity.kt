package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val salesList = generateSalesList() // Генерируем список продаж

        val currentCalendar = Calendar.getInstance() // Текущая дата
        val oneYearAgoCalendar = Calendar.getInstance()
        oneYearAgoCalendar.add(Calendar.YEAR, -1) // Дата, которая была год назад

        val filteredSalesList = salesList.filter { sale ->
            val saleDateCalendar = Calendar.getInstance()
            val saleDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(sale.saleDate)
            saleDateCalendar.time = saleDate
            saleDateCalendar.after(oneYearAgoCalendar) // Фильтрация продаж, совершенных менее года назад
        }

        val adapter = SaleAdapter(filteredSalesList) // Создаем адаптер для отфильтрованного списка

        recyclerView.adapter = adapter // Устанавливаем адаптер в RecyclerView
    }

    private fun generateSalesList(): List<Sale> {
        return listOf(
            Sale("Иванов", "Товар1", 10, 100.0, "2022-06-01"),
            Sale("Петров", "Товар2", 5, 200.0, "2023-06-02"),
            Sale("Сидоров", "Товар3", 8, 150.0, "2024-06-03")
        )
    }
}