package day18;

import java.util.List;

public interface HeroOperatable {
    List<Hero> findAllHero();
    int updateHeroById(Hero hero);
    int insertHero(Hero hero);
    int deleteHeroById(int id);
}
