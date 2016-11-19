package ui

import _SurnameName.createGame
import bridges.BridgesInfo
import bridges.bridgeInfoForLevels
import java.io.File

fun getSampleBoard(): Pair<String, BridgesInfo?> {
    val fileName = "level01.txt"
    val file = File("levels/bloxorz/$fileName")
//    val fileName = "bridgeLevel08.txt"
//    val fileName = "lightCellsLevel1.txt"
//    val file = File("levels/bridges/$fileName")
    val bridgesInfo = bridgeInfoForLevels[fileName]
    return file.readText() to bridgesInfo
}

fun main(args: Array<String>) {
    val (board, bridgesInfo) = getSampleBoard()
    val game = createGame(board, bridgesInfo)
    println(game)

    val path = game.suggestMoves()

    if (path == null) {
        println("There is no solution for this board")
        return
    }
    println(path)

    for (direction in path) {
        game.processMove(direction)
        println(game)
        println("-------------------")
    }
}