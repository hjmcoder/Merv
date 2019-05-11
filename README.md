# MERV

MERV (Multi Expandable RecyclerView) is library that you can use it for nested expandable RecyclerView.


<div style="text-align: center">
    <table>
        <tr>
            <td style="text-align: center">
              ![](merv.gif)
            </td>            
                   
        </tr>
         </table>
</div>
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

### Sample Data, Nested ArrayList with MervModel

```
    private ArrayList<MervModel> getMervs() {
        ArrayList<MervModel> mervModels = new ArrayList<>();
        MervModel a1 = new MervModel(0,"a1",false,true,false);
        MervModel a2 = new MervModel(1,"a2",false,true,false);
        MervModel a3 = new MervModel(2,"a3",false,false,false);
        MervModel b1 = new MervModel(3,"b1",true,false,false);
        MervModel b2 = new MervModel(4,"b2",true,false,false);
        MervModel b3 = new MervModel(5,"b3",true,true,false);
        MervModel b4 = new MervModel(5,"b4",true,false,false);
        MervModel b5 = new MervModel(5,"b5",true,false,false);
        MervModel c1 = new MervModel(6,"c1",true,false,false);
        MervModel c2 = new MervModel(6,"c2",true,false,false);
        MervModel c3 = new MervModel(6,"c3",true,false,false);
        MervModel c4 = new MervModel(6,"c4",true,false,false);
        MervModel c5 = new MervModel(6,"c5",true,false,false);

        a1.setChildList(new ArrayList<MervModel>());
        a2.setChildList(new ArrayList<MervModel>());
        b2.setChildList(new ArrayList<MervModel>());
        b3.setChildList(new ArrayList<MervModel>());

        b3.getChildList().add(c1);
        b3.getChildList().add(c2);
        b3.getChildList().add(c3);
        b3.getChildList().add(c4);
        b3.getChildList().add(c5);

        a2.getChildList().add(b2);
        a2.getChildList().add(b3);
        a2.getChildList().add(b4);
        a2.getChildList().add(b5);
        a1.getChildList().add(b1);


        mervModels.add(a1);
        mervModels.add(a2);
        mervModels.add(a3);

        return mervModels;
    }
```
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
