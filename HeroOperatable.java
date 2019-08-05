package day18;

import java.util.List;

public interface HeroOperatable {
    /**
     * @return 将所有的数据返回
     */
    List<Hero>  findAllHero();

    /**
     * @param hero 待修改的对象
     * @return 受影响的行数
     */
    int updateHeroById(Hero hero);

    /**
     * 添加数据
     * @param hero
     * @return 受影响的行数
     */
    int insertHero(Hero hero);

    /**
     * 根据ID删除
     * @param id
     * @return 受影响的行数
     */
    int deleteHeroById(int id );

}
