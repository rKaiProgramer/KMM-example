package com.example.kmmExample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmmExample.Hanoi

class HanoiActivity : ComponentActivity() {
    private val hanoi = Hanoi()
    private val step = mutableStateOf(0)

    private var totalStep = mutableStateOf(hanoi.getTotalStepNum())
    private val diskNum = mutableStateOf(10)
    private val diskOptions = List<Int>(10) { it + 1 }
    private var expanded = mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DiskSettingView()
                StepView()
                TowersView()
            }

        }

    }

    @Composable
    fun DiskSettingView() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { expanded.value = !expanded.value }) {
                Text("${diskNum.value} disks", fontSize = 20.sp)
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                )
            }
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
            ) {
                diskOptions.forEach { diskNum ->
                    DropdownMenuItem(onClick = {
                        expanded.value = false
                        step.value = 0
                        hanoi.setDiskNum(diskNum)
                        totalStep.value = hanoi.getTotalStepNum()
                        this@HanoiActivity.diskNum.value = diskNum
                    }) {
                        Text(text = "$diskNum disks", fontSize = 20.sp)
                    }
                }
            }
        }
    }

    @Composable
    fun StepView() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(10.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                step.value--

            }, enabled = step.value != 0) {
                Text("previous step", fontSize = 20.sp)
            }

            Text(
                modifier = Modifier.padding(5.dp),
                text = "${step.value} / ${totalStep.value}",
                textAlign = TextAlign.Center, fontSize = 30.sp
            )

            Button(
                onClick = {
                    step.value++
                }, enabled = step.value != hanoi.getTotalStepNum()

            ) {
                Text(text = "next step", fontSize = 20.sp)
            }

        }
    }

    @Composable
    fun TowersView() {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .wrapContentSize(Alignment.Center),
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center),

                contentAlignment = Alignment.BottomCenter
            ) {

                RodView()
                val disks = hanoi.getDiskDistribution(step.value)[0]
                Column(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .padding(bottom = 13.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(3.dp)

                ) {
                    for (i in disks.size - 1 downTo 0) {
                        DiskView(disks[i], diskNum.value)
                    }
                }
            }



            Box(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center),
                contentAlignment = Alignment.BottomCenter
            ) {

                RodView()
                val disks = hanoi.getDiskDistribution(step.value)[1]
                Column(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .padding(bottom = 13.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    for (i in disks.size - 1 downTo 0) {
                        DiskView(disks[i], diskNum.value)
                    }
                }
            }

            Box(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center),
                contentAlignment = Alignment.BottomCenter
            ) {
                RodView()
                val disks = hanoi.getDiskDistribution(step.value)[2]
                Column(
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .padding(bottom = 13.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    for (i in disks.size - 1 downTo 0) {
                        DiskView(disks[i], diskNum.value)
                    }
                }
            }
        }
    }

    @Composable
    fun DiskView(
        viewNo: Int,
        diskNum: Int
    ) {
        Box(
            modifier = Modifier
                .width((120 * (diskNum - viewNo) / diskNum).dp)
                .height(15.dp)
                .clip(RectangleShape)
                .background(Color.Green)
        )
    }


    // rod to put Disk
    @Composable
    fun RodView() {
        Column(
            modifier = Modifier
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Box(
                modifier = Modifier
                    .width(10.dp)
                    .height(185.dp)
                    .clip(RectangleShape)
                    .background(Color.Gray)
            )
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(13.dp)
                    .clip(RectangleShape)
                    .background(Color.Gray)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DiskSettingView()
            StepView()
            TowersView()
        }
    }
}
