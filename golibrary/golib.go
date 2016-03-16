// Guide: http://www.sajalkayan.com/post/android-apps-golang.html
// Build-kommando: gomobile bind -o ../../../trash/Androidgotest/app/libs/androidtest.aar .

package golib

func IntegerFibonacci(n int) int {
	// var result int = 0
	// var i int
	// var j int
	//
	// for i = 0; i < n; i++ {
	//     for j = 0; j < n; j++ {
	//         result = (j*1*2*3*4*5*6)+i;
	//     }
	// }
	//
	// return result

	if n < 2 {
		return 1
	} else {
		return IntegerFibonacci(n-1) * IntegerFibonacci(n-2)
	}
}

func CreateArray(n int) int {
	slice := make([]int, n)
	for i := 0; i < n; i++ {
		slice[i] = n - i
	}
	return slice[0]
}

func BubbleSort(n int) int {

	slice := make([]int, n)
	for i := 0; i < n; i++ {
		slice[i] = n - i
	}

	temp := 0

	for i := 0; i < n; i++ {
		for j := 1; j < (n - i); j++ {
			if slice[j-1] > slice[j] {
				temp = slice[j-1]
				slice[j-1] = slice[j]
				slice[j] = temp
			}
		}
	}

	return slice[0]
}

func MemoryAllocation(n int) int {
	size := 4000 * n
	array := make([]byte, size)

	for i := 0; i < n; i++ {
		array[i] = 127
	}
	return array[n-1]
}
