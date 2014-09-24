tinyutils is a set of utitilies built on top of some famous utils libraries like Apache commons, google Guava, joda time to provide either something missing from these libraries or more sophiscated but easier to use functions.


### StopWatch

A stop watch able to mark multiple time in one instance with minimum code.

    private void yourMethod() {
        StopWatch stopWatch = new StopWatch("a stop watch").start();
        
        //do something
        
        stopWatch.mark("phase 1");
        
        //do something
        
        stopWatch.mark("phase 2");
        
        //do something
        
        stopWatch.mark("phase 3");
        
        stopWatch.prettyPrint();   
    }

This will print in the console something like:
StopWatch[a stop watch]:    
-----> (30 ms) -----> phase 1   
-----> (42 ms) -----> phase 2  
-----> (20 ms) -----> phase 3  
Total time: 92 ms.  

