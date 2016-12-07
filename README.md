# play-big-app
Big Spring application (500+ java classes)

Demo application for testing Spring framework performance.

## How to run
* `git clone https://github.com/asolntsev/big-app.spring.git`
* `cd big-app.spring`
* `gradle`
* open `http://localhost:8000/` in browser

## How to trigger reloading classes
* Modify file `src/main/java/util/Util.java` and replace `Object` with `Integer`
* Make project
* Refresh `http://localhost:8000/` in browser
* Expected result: Spring reloads classes
  * It takes ~40 seconds on my laptop, but works
  * No classloading issues
