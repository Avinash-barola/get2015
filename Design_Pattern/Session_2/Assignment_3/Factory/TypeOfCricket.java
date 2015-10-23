package Session_2.Assignment_3.Factory;

import Session_2.Assignment_3.Cricket;
import Session_2.Assignment_3.Enum.GameType;
import Session_2.Assignment_3.Model.*;


public class TypeOfCricket {
	public Cricket getCricketType(GameType gameType) {
		if(gameType.equals(GameType._20__20)) {
			return _20_20.get_20_20Instance();
		}
		else if(gameType.equals(GameType.OneDay)) {
			return One_Day.getOneDayInstance();
		}
		else {
			return Test.getTestInstance();
		}
	}
}
