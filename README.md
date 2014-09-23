tinyspring
==========

## Utilities

### StopWatch

I know Commons and Guava and Spring they all have StopWatch. I just tried to make this one writing less code to use and be able to mark multiple time in one instance.

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

