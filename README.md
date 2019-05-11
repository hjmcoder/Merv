# MERV

MERV (Multi Expandable RecyclerView) is library that you can use it for nested expandable RecyclerView.

## Installation
### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```bash
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
### Step 2. Add the dependency
```bash
dependencies {
       implementation 'com.github.rvhamed:merv:v1.0-beta01'
}
```
## Usage

### Step 1. Add MervView to your layout
```bash
<com.hamedrahimvand.merv.MervView
        android:id="@+id/mervView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />

```
### Step 2. Create an object of MervView and find MervView by id

```java
MervView mervView = findViewById(R.id.mervView);
```
### Step 3. Generate an MervAdapter and set a listener, when item clicked
```java
final MervAdapter mervAdapter = new MervAdapter(getMervs(), new MervClick.OnItemClickListener() {
            @Override
            public void OnItemClick(MervModel mervModel) {
                Toast.makeText(MainActivity.this,mervModel.getName(),Toast.LENGTH_SHORT).show();
            }
        });
```
### Step 4. Be Optional, Create your own config for list.
```java
 mervAdapter.setMervConfig( new MervConfig.MervConfigBuilder()
     .rotationCollapse(0)
     .rotationExpand(90) 
     .sideDrawable(ContextCompat.getDrawable(this,R.drawable.ic_launcher_foreground))                
     .textColor(ContextCompat.getColor(this,R.color.colorPrimaryDark)).build());
```
### Step 5. At least, set adapter to MervView

```java
mervView.setMervAdapter(mervAdapter);
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
