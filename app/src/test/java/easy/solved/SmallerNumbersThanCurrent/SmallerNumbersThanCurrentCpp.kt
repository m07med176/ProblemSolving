package easy.solved.SmallerNumbersThanCurrent;

object SmallerNumbersThanCurrentCpp {
    init{
        System.loadLibrary("problemsolving");
    }

    val solution0 = object : SmallerNumbersThanCurrent.Solution{
        override fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
            return smallerNumbersThanCurrent(nums)
        }

    }

    external fun smallerNumbersThanCurrent(nums: IntArray): IntArray
    
}
