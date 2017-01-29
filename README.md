# Easy Permissions

An extremely simple and lightweight android library that helps you with Android Runtime Permissions.

---

## Usage:

### Adding the depencency

Add this to your root *build.gradle* file:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Now add the dependency to your app build.gradle file:

```
compile 'com.github.marcoscgdev:EasyPermissions:1.2'
```

### Request permissions

```
String[] permissions = {EasyPermissions.WRITE_EXTERNAL_STORAGE, EasyPermissions.ACCESS_FINE_LOCATION, ...};
int requestCode = 0;
EasyPermissions.requestPermissions(activity, permissions, requestCode);
```

### 

```
@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    for (int i = 0; i < permissions.length; i++) {
        String permission = permissions[i];
        int grantResult = grantResults[i];
        if (permission.equals(EasyPermissions.WRITE_EXTERNAL_STORAGE)) {
            if (grantResult == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "WRITE_EXTERNAL_STORAGE Granted", Toast.LENGTH_LONG).show();
            }
        }
    }
}
```

---

##License

```
Copyright 2017 Marcos Calvo García

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
