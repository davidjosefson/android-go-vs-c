// Guide: http://www.sajalkayan.com/post/android-apps-golang.html
// Build-kommando: gomobile bind -o ../../../trash/Androidgotest/app/libs/androidtest.aar .
// Build-kommando: gomobile bind -o ../../../../code/android-go-vs-c/app/libs/golib.aar | cp hello.go ../../../../code/android-go-vs-c/golibrary/golib.go

package golib

func IntegerMultiplication(n int) int {
	var result int = 0
	var i int
	var j int

	for i = 0; i < n; i = i + 1 {
		for j = 0; j < n; j = j + 1 {
			result = j*(j+2) - j*(j+1) + i
		}
	}

	return result
}

func FloatMultiplication(n float64) float64 {
	var result float64 = 0
	var i float64
	var j float64

	for i = 0; i < n; i = i + 1 {
		for j = 0; j < n; j = j + 1 {
			result = j*(j+1.123456789) - j*(j+0.987654321) + i
		}
	}

	return result
}

// func IntegerFibonacci(n int) int {
//
// 	if n < 2 {
// 		return 1
// 	} else {
// 		return IntegerFibonacci(n-1) * IntegerFibonacci(n-2)
// 	}
// }

func CreateArray(n int) int {
	slice := make([]int, n)
	for i := 0; i < n; i++ {
		slice[i] = n - i
	}
	return slice[n-1]
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

// func MemoryAllocation(n int) int {
// 	size := 4000 * n
// 	array := make([]byte, size)
//
// 	for i := 0; i < n; i++ {
// 		array[i] = 127
// 	}
// 	return array[n-1]
// }
