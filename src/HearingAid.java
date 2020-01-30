public class HearingAid {
    //I assume that an id and type cant be changed
    private final int ID;
    private final String TYPE;
    private boolean rentalStatus; //True if it is rented out and false if not
    private String rentalTaker;

    //I implement two constructor (one with and one without a rental taker),
    //since the hearing aid is not necessarily rented, and therefore won't have a rental taker
    //If a rental taker is not added then then it's not rented out and rentalStatus will therefor be false
    //If a rental taker is added then then it's rented out and rentalStatus will therefor be true

    /**
     *  HearingAid constructor, initializes an object of the hearing aid class, with a rentTaker and rentalStatus equal true
     * @param id int, the identification of the hearing aid, a number between 1001-9999
     * @param type String, the type of the hearing aid
     * @param rentalTaker String, the rental taker of the hearing aid
     */
    public HearingAid(int id, String type, String rentalTaker) {
        if(id < 1001 || id > 9999){
            //Throw illegal argument exception if the ID is not between 1001 and 9999
            throw new IllegalArgumentException("ID has to be between 1001 and 9999");
        }
        this.ID = id;
        this.TYPE = type;
        this.rentalStatus = true; //Sets rental status to true since there is a rental taker
        this.rentalTaker = rentalTaker;
    }

    /**
     * HearingAid constructor, initializes an object of the hearing aid class, without a rentTaker and rentalStatus equal false
     * @param id int, the identification of the hearing aid, a number between 1001-9999
     * @param type String, the type of the hearing aid
     */
    public HearingAid(int id, String type) {
        if(id < 1001 || id > 9999){
            //Throw illegal argument exception if the ID is not between 1001 and 9999
            throw new IllegalArgumentException("ID has to be between 1001 and 9999");
        }
        this.ID = id;
        this.TYPE = type;
        this.rentalStatus = false; //Sets rental status to false since there is not a rental taker
    }

    //I needed to have getID, getTYPE, and isRentalStatus cause i use them in the HearingAidCentral class
    //The rentalTaker variable i only i needed to use in this class, therefore i could just access the variable directly

    /**
     * getID int, returns the identification of the hearing aid
     * @return ID final int, the identification of the hearing aid
     */
    public int getID() {
        return ID;
    }

    /**
     * getTYPE String, returns the type of the hearing aid
     * @return TYPE final String, the type of the hearing aid
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * isRentalStatus boolean, returns the rental status of the equipment. True for rented by someone, and false for available
     * @return rentalStatus String, the rental status of the equipment. True for rented by someone, and false for available
     */
    public boolean isRentalStatus() {
        return rentalStatus;
    }


    /**
     * setRentalStatus void, sets the rental status of the hearing aid, if it is to be set to false(available), it makes sure to erase the rental taker
     * @param rentalStatus boolean, the rental status of the hearing aid
     */
    public void setRentalStatus(boolean rentalStatus) {
        //Here I set the rental taker to null if the status is to be set to false, since then there won't be anyone that rents the hearing aid anymore
        if(rentalStatus == false){
            this.rentalTaker = null;
        }
        this.rentalStatus = rentalStatus;
    }

    /**
     * setRentalTaker void, checks rental status, and if false changes it to true, and then sets the rental taker
     * @param rentalTaker String, the person that rents the hearing aid
     */
    public void setRentalTaker(String rentalTaker) {
        //Here i check if there are any rental takers, since if there aren't I have to change it to rented out
        if(this.rentalStatus == false){
            this.rentalStatus = true;
        }
        this.rentalTaker = rentalTaker;
    }

    /**
     * equals boolean, checks if an object is equal to an hearing aid object. Using the ID as the determining factor
     * @param o Object, an object of the class Object
     * @return true/false boolean, if the objects are equal true is returned, if not then false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //Checks if the objects hav the same memory reference
        if (!(o instanceof HearingAid)) return false; //Checks if the parameter object is an object of the HearingAid class
        HearingAid hearingAid = (HearingAid) o; //Parses the object to the HearingAid class
        return this.ID == hearingAid.ID; //Checks if their id's are the same
    }

    /**
     * toString String, creates a string containing all information about an hearing aid object. Based on the rental state the method will return a String with or without a rental taker (rented = with, and available = without)
     * @return a String, string containing all information about an hearing aid object. Based on the rental state the method will return a String with or without a rental taker (rented = with, and available = without)
     */
    @Override
    public String toString() {
        if(rentalStatus == true) return this.ID + " "  + this.TYPE + " rented to " + this.rentalTaker;
        else return this.ID + " "  + this.TYPE + " available";
    }
}
