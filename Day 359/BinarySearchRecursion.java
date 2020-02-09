private static int binarySearch( Comparable [ ] arr, Comparable i,int low, int high ){
    if( low > high ){  return -1;  }

    int mid = ( low + high ) / 2;

    if( arr[ mid ].compareTo( i ) < 0 )
        return binarySearch( arr, x, mid + 1, high );
    else if( a[ mid ].compareTo( i ) > 0 )
        return binarySearch( arr, x, low, mid - 1 );
    else
        return mid;
    }
}
