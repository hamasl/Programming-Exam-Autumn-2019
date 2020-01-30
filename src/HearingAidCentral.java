import java.util.ArrayList;

public class HearingAidCentral {
    private final String NAME;
    //I choose an array list since it's easy to add and remove hearing aids,
    //and in real life there will be hearing aids that will get broken and removed from the list
    //The central will also have buy new hearing aids, which will get added to the it
    private ArrayList<HearingAid> hearingAidRegister;

    /**
     * HearingAidCentral constructor, creates an object of the HearingAidCentral class, that consists of a name and a list of all the hearing aids
     * @param name String, the name of the hearing aid central
     */
    public HearingAidCentral(String name) {
        this.NAME = name;
        this.hearingAidRegister = new ArrayList<>();
    }

    //I did not need any get or set methods, since all the variables i needed from this class was used in this class, therefore i could just access the variables directly


    //Since I implemented two constructors in the hearing aid class I have to make two add methods
    /**
     * addNewHearingAid boolean, for hearing aids that are rented out. Adds a new hearing aid to the register if the hearing aid is not registered, and the ID is not over 9999
     * @param type String, the type of the hearing aid
     * @param rentalTaker String, the rental taker of the hearing aid
     * @return true/false boolean, if the hearing aid was registered then true, if not false
     */
    public boolean addNewHearingAid(String type, String rentalTaker){
        //Auto assigning ID to minimize human error
        int ID = (1001 + hearingAidRegister.size());
        //Making sure that the hearing aid is not already registered, and the ID number does not surpass 9999
        if(this.hearingAidRegister.contains(new HearingAid(ID,type,rentalTaker)) || ID > 9999) return false;
        this.hearingAidRegister.add(new HearingAid(ID,type,rentalTaker));
        return true;
    }

    /**
     * addNewHearingAid boolean, for hearing aids that are not rented out. Adds a new hearing aid to the register if the hearing aid is not registered, and the ID is not over 9999
     * @param type String, the type of the hearing aid
     * @return true/false boolean, if the hearing aid was registered then true, if not false
     */
    public boolean addNewHearingAid(String type){
        //Auto assigning ID to minimize human error
        int ID = (1001 + hearingAidRegister.size());
        //Making sure that the hearing aid is not already registered, and the ID number does not surpass 9999
        if(this.hearingAidRegister.contains(new HearingAid(ID,type)) || ID > 9999) return false;
        this.hearingAidRegister.add(new HearingAid(ID,type));
        return true;
    }

    /**
     * getIndexByID int, gets the index of an hearing aid object in the hearing aid register, using the objects id
     * @param id int, the id of the hearing aid object
     * @return index int, the index of the hearing aid object in the hearing aid register
     */
    public int getIndexById(int id){
        boolean found = false;
        int index = -1;
        //Using a while loop to minimizing the time it has to run, since it will stop when the object has been found
        while (index < hearingAidRegister.size() && found == false){
            index++;
            if(hearingAidRegister.get(index).getID() == id){
                found = true;
            }
        }
        return index;
    }

    /**
     * rentOutHearingAid boolean, rents out the hearing aid object to a rental taker, if it is not already taken
     * @param id int, the id of the hearing aid object
     * @param rentalTaker String, the rental taker of the hearing aid
     * @return true/false boolean, if the hearing aid was rented out then true, if not false
     */
    public boolean rentOutHearingAid(int id, String rentalTaker){

        if(this.hearingAidRegister.get(this.getIndexById(id)).isRentalStatus() == true)return false; //Checks if the hearing aid is already rented out
        this.hearingAidRegister.get(this.getIndexById(id)).setRentalTaker(rentalTaker); //If not then it sets a new person to rent the hearing aid
        return true;
    }

    /**
     * rentOutHearingAid boolean, ends the rent of the hearing aid object, if it is rented by someone
     * @param id int, the id of the hearing aid object
     * @return true/false boolean, if the hearing aid rent was ended  then true, if not false
     */
    public boolean endRentingAgreement(int id){

        if(this.hearingAidRegister.get(this.getIndexById(id)).isRentalStatus() == false)return false; //Checks if the hearing aid is not already rented out
        this.hearingAidRegister.get(this.getIndexById(id)).setRentalStatus(false); //If not then it is put to false
        return true;
    }

    /**
     * typeOfHearingAid ArrayList of objects of the HearingAid class. Makes an ArrayList of hearing aids, that are of a certain type and ar available
     * @param type String, the type of the hearing aid
     * @return copyArrayList ArrayList of objects of the HearingAid class. An ArrayList of hearing aids, that are of a certain type and ar available
     */
    public ArrayList<HearingAid> typeOfHearingAid(String type){
        ArrayList<HearingAid> copyArrayList = new ArrayList<>();
        for (HearingAid hearingAid : hearingAidRegister){
            if(hearingAid.getTYPE().toLowerCase().equals(type.toLowerCase()) && hearingAid.isRentalStatus() == false){
                    copyArrayList.add(new HearingAid(hearingAid.getID(), hearingAid.getTYPE()));
            }
        }
        return copyArrayList;
    }

    /**
     * specifiedArrayListToString String, creates a String out of the ArrayList in the parameter
     * @param specifiedArrayList ArrayList of HearingAid objects, an ArrayList containing objects of the HearingAid class
     * @return output String, a String containing all the information from the specifiedArrayList
     */
    public String specifiedArrayListToString(ArrayList<HearingAid> specifiedArrayList){
        String output = "Hearing aid central: " + NAME + "\nHearing aid register";
        for (HearingAid hearingAid : specifiedArrayList ){
            output += "\n" + hearingAid.toString();
        }
        return output;
    }

    /**
     * toString String, creates a String containing all the information from the hearingAidRegister
     * @return output String, a String containing all the information from the hearingAidRegister
     */
    @Override
    public String toString() {
        String output = NAME + "\nHearing aid register";
        for (HearingAid hearingAid : hearingAidRegister){
            output += "\n" + hearingAid.toString();
        }
        return output;
    }

}
