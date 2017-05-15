package com.kby.home.safety.mapper;

import com.kby.home.safety.model.RoomMonitor;
import com.kby.home.safety.model.RoomMonitorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomMonitorMapper {
    int countByExample(RoomMonitorExample example);

    int deleteByExample(RoomMonitorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomMonitor record);

    int insertSelective(RoomMonitor record);

    List<RoomMonitor> selectByExample(RoomMonitorExample example);

    RoomMonitor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomMonitor record, @Param("example") RoomMonitorExample example);

    int updateByExample(@Param("record") RoomMonitor record, @Param("example") RoomMonitorExample example);

    int updateByPrimaryKeySelective(RoomMonitor record);

    int updateByPrimaryKey(RoomMonitor record);
}