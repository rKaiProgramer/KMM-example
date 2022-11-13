package com.example.kmmExample

class Hanoi(private var diskNum: Int = 10) {
    private var towers = Array(3) { mutableListOf<Int>() }
    private val steps = mutableListOf<Array<MutableList<Int>>>()
    private var moves = 0

    init {
        initData()
    }

    private fun initData() {
        moves = 0
        steps.clear()
        towers = Array(3) { mutableListOf<Int>() }
        for (i in 0 until diskNum) {
            towers[0].add(i)
        }
        genSteps()
    }

    fun setDiskNum(diskNum: Int) {
        this.diskNum = diskNum
        initData()

    }

    fun getTotalStepNum(): Int {
        return moves
    }

    fun getDiskDistribution(step: Int): Array<MutableList<Int>> {
        return when {
            step >= steps.size -> {
                steps[steps.size - 1]
            }
            step < 0 -> {
                steps[0]
            }
            else -> {
                steps[step]
            }
        }
    }


    private fun genSteps() {
        steps.add(towers.map { it.toMutableList() }.toTypedArray())
        move(diskNum, 0, 2, 1)
    }

    private fun move(n: Int, from: Int, to: Int, via: Int) {
        if (n > 0) {
            move(n - 1, from, via, to)
            recordStep(n, from, to)
            move(n - 1, via, to, from)
        }
    }

    private fun recordStep(n: Int, from: Int, to: Int) {
        val e = towers[from].removeAt(towers[from].size - 1)
        towers[to].add(e)
        steps.add(towers.map { it.toMutableList() }.toTypedArray())
        moves++
    }


}