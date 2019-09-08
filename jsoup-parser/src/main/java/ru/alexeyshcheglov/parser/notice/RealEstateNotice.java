package ru.alexeyshcheglov.parser.notice;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RealEstateNotice extends Notice {
    private String address;
    private String floor;
    private String totalFloors;
    private String houseType;
    private String roomsCount;
    private String totalArea;
    private String kitchenArea;
    private String livingArea;
    private String developer;
    private String participationtype;
    private String objectName;
    private String buildingNumber;

    public RealEstateNotice(String url) {
        super(url);
//        this.address = super.getParser().parseAddress();
//        Map<String, String> parameters = super.getParser().parseHouseParameters();
//        this.floor = parameters.get(HouseInfo.FLOOR.getName());
//        this.totalFloors =  parameters.get(HouseInfo.TOTAL_FLOORS.getName());
//        this.houseType = parameters.get(HouseInfo.HOUSE_TYPE.getName());
//        this.roomsCount = parameters.get(HouseInfo.ROOMS_COUNT.getName());
//        this.totalArea = parameters.get(HouseInfo.AREA_TOTAL.getName());
//        this.kitchenArea = parameters.get(HouseInfo.AREA_KITCHEN.getName());
//        this.livingArea = parameters.get(HouseInfo.AREA_LIVING.getName());
//        this.developer = parameters.get(HouseInfo.DEVELOPER.getName());
//        this.participationtype = parameters.get(HouseInfo.PARTICIPATION_TYPE.getName());
//        this.objectName = parameters.get(HouseInfo.OBJECT_NAME.getName());
//        this.buildingNumber = parameters.get(HouseInfo.BUILDING_NUMBER.getName());
    }

    @Override
    public String toString() {
        return "RealEstateNotice{" +
                "address='" + address + '\'' +
                ", floor='" + floor + '\'' +
                ", totalFloors='" + totalFloors + '\'' +
                ", houseType='" + houseType + '\'' +
                ", roomsCount='" + roomsCount + '\'' +
                ", totalArea='" + totalArea + '\'' +
                ", kitchenArea='" + kitchenArea + '\'' +
                ", livingArea='" + livingArea + '\'' +
                ", developer='" + developer + '\'' +
                ", participationtype='" + participationtype + '\'' +
                ", objectName='" + objectName + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", " + super.toString() + '\'' +
                "}";
    }
}
