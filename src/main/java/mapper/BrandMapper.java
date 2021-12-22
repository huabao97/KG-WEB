package mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import pojo.Brand;
import java.util.List;

public interface BrandMapper {

    @Select("select  * from db.tb_brand")
    @ResultMap("resultMapper")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    @ResultMap("resultMapper")
    void add(Brand brand);

    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_brand limit #{begin} , #{size}")
    @ResultMap("resultMapper")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from tb_brand ")
    int selectTotalCount();



    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Brand brand);

    @Delete("delete from tb_brand where  id=#{id}")
    void deleteById(int id);

    @Update("update tb_brand set brand_name=#{branName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status}")
    void update(Brand brand);
}
