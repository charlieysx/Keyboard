# Keyboard
Listening to the soft keyboard open or close

## gif

![gif](/raw/keyboard1.gif)
![gif](/raw/keyboard2.gif)

## Usage

* constructor method
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

## License

```
Copyright 2017 CodeBear

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
