package com.example.db_final.mapper;
import com.example.db_final.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.ArrayList;
import java.util.Date;
@Mapper
public interface PostMapper {
    @Select("select * from Post where pid = #{id}")
    Post selectPostById(int id);

    @Select("select * from Post where status = 0 order by date desc")
    ArrayList<Post> selectAllPost();

    @Select("select * from Post inner join User on User.uid = Post.uid and username = #{username} order by date desc")
    ArrayList<Post> selectAllPostByUsername(String username);

    @Select("select * from Post where tid = #{tid} order by date desc")
    ArrayList<Post> selectAllPostByTid(int tid);

    @Select("select * from Post where uid = #{uid} and tid = #{tid} order by date desc")
    ArrayList<Post> selectAllPostByByUidAndTid(int uid, int tid);

    @Insert("insert into Post (uid, tid, p_title, p_body, p_date) values(#{uid},#{tid},#{p_title},#{p_body},#{p_date})")
    int insertPost(int uid, int tid, String p_title, String  p_body,Date p_date);

    @Update("update Post set status = #{status} where pid = #{id}")
    int updateStatus(int pid,boolean status);

}
