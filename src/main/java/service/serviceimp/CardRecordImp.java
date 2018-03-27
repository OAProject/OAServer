package service.serviceimp;

import java.text.SimpleDateFormat;
import mapper.SignCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CardRecordid")
public class CardRecordImp {

    @Autowired
    private SignCardMapper cardRecordmap;
    public void insertTimeCrad(int userid, int state,String limits,String location,int signType)
    {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date=new java.util.Date();
        String str=sdf.format(date);

        String[] dateTime = str.split(" ");

        String years = "";
        String months = "";
        String days = "";
        String time = "";

        if (dateTime.length > 1)
        {

            time = dateTime[1];
            String date_ = dateTime[0];
            String[] dateArray = date_.split("-");
            if (dateArray.length>2)
            {
                years = dateArray[0];
                months = dateArray[1];
                days = dateArray[2];
            }
        }


        cardRecordmap.insertCardRecord(userid,years,months,days,time,state,limits,location,signType);

    }
}
