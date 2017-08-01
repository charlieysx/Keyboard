# Keyboard
Listening to the soft keyboard open or close

## gif

![gif](/raw/keyboard1.gif)
![gif](/raw/keyboard2.gif)

## Gradle

* add jitpack to your project's build.gradle:
```xml  
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

* add the compile statement to your module's build.gradle:
```xml
dependencies {
    compile 'com.codebear.keyboard:keyboard-listener:1.0.0'
}
```

## Usage

* construction method
```java
public CBKeyboard(Activity activity);
public CBKeyboard(Fragment fragment);
public CBKeyboard(android.app.Fragment fragment);
```

```java
new CBKeyboard(this)
    .setOnNavListener(new OnNavListener() {
        @Override
        public void onNavOpen(int height) {
            // "nav open : " + height;
        }

        @Override
        public void onNavClose() {
            //"nav close";
        }
    })
    .setOnKeyboardListener(new OnKeyboardListener() {
        @Override
        public void onKeyboardOpen(int height) {
            // "keyboard open : " + height;
        }

        @Override
        public void onKeyboardClose() {
            // "keyboard close";
        }
    })
    .listener();
```
