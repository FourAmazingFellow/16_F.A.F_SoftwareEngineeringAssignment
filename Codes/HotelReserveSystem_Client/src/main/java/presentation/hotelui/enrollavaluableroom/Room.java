package presentation.hotelui.enrollavaluableroom;

import java.text.ParseException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.RoomType;
import vo.RoomVO;

public class Room {
	private StringProperty roomType;
	private StringProperty roomNum;
	private StringProperty roomPrice;
	private StringProperty address;

	public Room(RoomVO roomVO) {
		this.roomType = new SimpleStringProperty(RoomType.enumToChinese(roomVO.roomType));
		this.roomNum = new SimpleStringProperty(String.valueOf(roomVO.roomNum));
		this.roomPrice = new SimpleStringProperty(String.valueOf(roomVO.roomPrice));

	}

	public StringProperty roomTypeProperty() {
		return roomType;
	}

	public StringProperty roomNumProperty() {
		return roomNum;
	}

	public StringProperty roomPriceProperty() {
		return roomPrice;
	}

	public RoomType getRoomType() {
		return (RoomType) RoomType.chineseToEnum(roomType.get());
	}

	public void setRoomType(RoomType roomType) {
		this.roomType.set(RoomType.enumToChinese(roomType));
	}

	public int getRoomNum() {
		return Integer.parseInt(roomNum.get());
	}

	public void setRoomNum(int roomNum) {
		this.roomNum.set(String.valueOf(roomNum));
	}

	public int getRoomPrice() {
		return Integer.parseInt(roomPrice.get());
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice.set(String.valueOf(roomPrice));
	}

	public String getAddress() {
		return address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	public RoomVO toVO(String address) throws ParseException {
		return new RoomVO(getRoomType(), getRoomNum(), getRoomPrice(), address);
	}
}
