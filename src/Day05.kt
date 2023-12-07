fun main() {
    // Any source numbers that aren't mapped correspond to the same destination number.
    // So, seed number 10 corresponds to soil number 10.
    fun part1(input: List<String>): Long {
        val seeds = input[0].split(" ").drop(1)
        val seedsSmallestMap = mutableMapOf<Long, Long>()
        for (s in seeds) {
            seedsSmallestMap[s.toLong()] = s.toLong()
        }
        var listMaps = mutableListOf<Pair<LongRange, LongRange>>()
        for (i in 2..<input.size) {
            if (input[i].isBlank() || i == input.size-1) {
                for (s in seeds) {
                    for (m in listMaps) {
                        if (m.second.contains(seedsSmallestMap[s.toLong()])) {
                            seedsSmallestMap[s.toLong()] = m.first.first + (seedsSmallestMap[s.toLong()]?.minus(m.second.first)!!)
                            break
                        }
                    }
                }
                println(seedsSmallestMap.toString())
            } else if (input[i].contains("map")) {
                listMaps.clear()
            } else {
                val map = input[i].split(" ")
                listMaps.add(Pair(LongRange(map[0].toLong(), map[0].toLong()+map[2].toLong()-1),
                    LongRange(map[1].toLong(), map[1].toLong()+map[2].toLong()-1)))
            }
        }
        return seedsSmallestMap.values.min()
    }

    fun part2(input: List<String>): Long {
        val seeds = input[0].split(" ").drop(1)
        val seedsSmallestMap = mutableMapOf<Long, Long>()
        for (s in seeds.indices) {
            if (s%2==1) {
                for (d in 0..<seeds[s].toLong()) {
                    seedsSmallestMap[seeds[s-1].toLong()+d] = seeds[s-1].toLong()+d
                }
            }
        }
        var listMaps = mutableListOf<Pair<LongRange, LongRange>>()
        for (i in 2..<input.size) {
            if (input[i].isBlank() || i == input.size-1) {
                for (s in seeds) {
                    for (m in listMaps) {
                        if (m.second.contains(seedsSmallestMap[s.toLong()])) {
                            seedsSmallestMap[s.toLong()] = m.first.first + (seedsSmallestMap[s.toLong()]?.minus(m.second.first)!!)
                            break
                        }
                    }
                }
                println(seedsSmallestMap.toString())
            } else if (input[i].contains("map")) {
                listMaps.clear()
            } else {
                val map = input[i].split(" ")
                listMaps.add(Pair(LongRange(map[0].toLong(), map[0].toLong()+map[2].toLong()-1),
                    LongRange(map[1].toLong(), map[1].toLong()+map[2].toLong()-1)))
            }
        }
        return seedsSmallestMap.values.min()
    }
}
