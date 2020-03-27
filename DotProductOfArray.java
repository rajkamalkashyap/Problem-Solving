public static int dotProduct( int[] array1, int[] array2 ) throws IllegalArgumentException {
    // TODO: Implement solution

    int sum = 0;
    if( array1 == null || array2 == null ) {
      throw new IllegalArgumentException( "Null array is not a valid input." );
    }

    if( array1.length == 0 || array2.length == 0 ) {
      throw new IllegalArgumentException( "Empty array is not a valid input." );
    }

    if( array1.length != array2.length ) {
      throw new IllegalArgumentException( "Input arrays should be of equal length." );
    }

    for( int i = 0; i < array1.length; i++ ) {
      sum += array1[i] * array2[i];
    }

    System.out.println( "Result of the dot product of array1 and array2 is : " + sum );
    return sum;

  }
