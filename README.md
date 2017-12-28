# lrxcdialog
Android Smiple Load Dialog

![GIF.gif](http://upload-images.jianshu.io/upload_images/2803682-e5b60c6a49471862.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


Step 1.  Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
  
  Step 2. Add the dependency
```                        
	dependencies {
	        compile 'com.github.Lrxc:lrxcdialog:1.2'
	}
``` 
  Step 3. User in Activity
	LoadDialog(this).setText("请求中").show()
