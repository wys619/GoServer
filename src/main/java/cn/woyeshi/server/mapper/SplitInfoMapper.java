package cn.woyeshi.server.mapper;

import cn.woyeshi.server.domain.SplitInfo;
import cn.woyeshi.server.domain.SplitInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SplitInfoMapper {
    long countByExample(SplitInfoExample example);

    int deleteByExample(SplitInfoExample example);

    int deleteByPrimaryKey(Integer splitId);

    int insert(SplitInfo record);

    int insertSelective(SplitInfo record);

    List<SplitInfo> selectByExample(SplitInfoExample example);

    SplitInfo selectByPrimaryKey(Integer splitId);

    int updateByExampleSelective(@Param("record") SplitInfo record, @Param("example") SplitInfoExample example);

    int updateByExample(@Param("record") SplitInfo record, @Param("example") SplitInfoExample example);

    int updateByPrimaryKeySelective(SplitInfo record);

    int updateByPrimaryKey(SplitInfo record);
}