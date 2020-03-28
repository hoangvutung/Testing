package testing.task4;

public enum THIRDPAGE_DATA {
	CHECK_BOXES(new String[]{"Water", "Earth", "Wind", "Fire"}),
    RADIOS(new String[]{"Gold", "Silver", "Bronze", "Selen"}),
    DROP_COLORS(new String[]{"Red", "Green", "Blue", "Yellow"}),
    LOG(new String[]{"Water: condition changed to true","metal: value changed to Selen",});
  
    String[] strArr;
    THIRDPAGE_DATA(String[] strArr){
        this.strArr = strArr;
    }
}
