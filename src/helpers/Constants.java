package helpers;

public class Constants {
    //general
    public static final int LEVEL_EXPERIENCE = 250;
    public static final int EXPERIENCE = 200;
    public static final int SMALL_EXPERIENCE = 40;
    public static final int FRACTION_EXP = 50;
    // pyromancer fireblast
    public static final int PYROMANCER_HP = 500;
    public static final int PYROMANCER_HP_UP = 50;
    public static final int FIREBLAST_DMG = 350;
    public static final int FIREBLAST_UP = 50;
    public static final float FIREBLAST_KNIGHT = 1.2f;
    public static final float FIREBLAST_PYRO = 0.9f;
    public static final float FIREBLAST_ROGUE = 0.8f;
    public static final float FIREBLAST_WIZARD = 1.05f;
    // pyromancer ignite
    public static final int IGNITE_BASE_DMG = 150;
    public static final int IGNITE_OVERTIME = 50;
    public static final int IGNITE_BASE_UP = 20;
    public static final int IGNITE_OVER_UP = 30;
    public static final int IGNITE_ROUNDS = 3;
    public static final float IGNITE_KNIGHT = 1.2f;
    public static final float IGNITE_PYRO = 0.9f;
    public static final float IGNITE_ROGUE = 0.8f;
    public static final float IGNITE_WIZARD = 1.05f;
    //volcanic bonus
    public static final float VOLCANIC_LAND = 1.25f;
    //knight
    public static final int KNIGHT_HP = 900;
    public static final int EXECUTE_DMG = 200;
    public static final int SLAM_DMG = 100;
    public static final int KNIGHT_HP_UP = 80;
    public static final int EXECUTE_UP = 30;
    public static final float EXECUTE_ROGUE = 1.15f;
    public static final float EXECUTE_PYRO = 1.1f;
    public static final float EXECUTE_WIZARD = 0.8f;
    public static final int SLAM_UP = 40;
    public static final float SLAM_KNIGHT = 1.2f;
    public static final float SLAM_ROGUE = 0.8f;
    public static final float SLAM_PYRO = 0.9f;
    public static final float SLAM_WIZARD = 1.05f;
    public static final float KNIGHT_LAND = 1.15f;
    public static final float EXECUTE_KILL = 0.2f;
    public static final float EXECUTE_KILL_ADD = 0.01f;
    // wizard
    public static final int WIZARD_HP = 400;
    public static final int WIZARD_HP_UP = 30;
    public static final float DESERT_LAND = 1.1f;
    // wizard drain
    public static final float DRAIN_PERCENT = 0.2f;
    public static final float DRAIN_UP = 0.05f;
    public static final float DRAIN_KNIGHT = 1.2f;
    public static final float DRAIN_ROGUE = 0.8f;
    public static final float DRAIN_PYRO = 0.9f;
    public static final float DRAIN_WIZARD = 1.05f;
    public static final float HP_PERCENT = 0.3f;
    // wizard deflect
    public static final float DEFLECT_PERCENT = 0.35f;
    public static final float DEFLECT_UP = 0.02f;
    public static final float DEFLECT_KNIGHT = 1.4f;
    public static final float DEFLECT_PYRO = 1.3f;
    public static final float DEFLECT_ROGUE = 1.2f;
    // rogue
    public static final float WOODS_LAND = 1.15f;
    public static final int ROGUE_HP = 600;
    public static final int ROGUE_HP_UP = 40;
    // rogue backstab
    public static final int BACKSTAB_DMG = 200;
    public static final int BACKSTAB_UP = 20;
    public static final int BACKSTAB_INDEX = 3;
    public static final float BACKSTAB_KNIGHT = 0.9f;
    public static final float BACKSTAB_ROGUE = 1.2f;
    public static final float BACKSTAB_PYRO = 1.25f;
    public static final float BACKSTAB_WIZARD = 1.25f;
    public static final float BACKSTAB_CRIT = 1.5f;
    //rogue paralysis
    public static final int PARALYSIS_DMG = 40;
    public static final int PARALYSIS_UP = 10;
    public static final int PARALYSIS_ROUNDS = 3;
    public static final int PARALYSIS_EXTRA = 6;
    public static final float PARALYSIS_KNIGHT = 0.8f;
    public static final float PARALYSIS_ROGUE = 0.9f;
    public static final float PARALYSIS_PYRO = 1.2f;
    public static final float PARALYSIS_WIZARD = 1.25f;

    //angels
    //dark angel
    public static final int DARK_KNIGHT_DMG = 40;
    public static final int DARK_PYRO_DMG = 30;
    public static final int DARK_WIZARD_DMG = 20;
    public static final int DARK_ROGUE_DMG = 10;
    //Life Giver
    public static final int LIFE_KNIGHT_DMG = 100;
    public static final int LIFE_PYRO_DMG = 80;
    public static final int LIFE_WIZARD_DMG = 120;
    public static final int LIFE_ROGUE_DMG = 90;
    //XPAngel
    public static final int XP_KNIGHT = 45;
    public static final int XP_PYRO = 50;
    public static final int XP_ROGUE = 40;
    public static final int XP_WIZARD = 60;
    //Spawner
    public static final int REVIVE_KNIGHT = 200;
    public static final int REVIVE_PYRO = 150;
    public static final int REVIVE_ROGUE = 180;
    public static final int REVIVE_WIZARD = 120;
    //DamageAngel
    public static final float DAMAGE_ANGEL_K = 0.15f;
    public static final float DAMAGE_ANGEL_P = 0.2f;
    public static final float DAMAGE_ANGEL_R = 0.3f;
    public static final float DAMAGE_ANGEL_W = 0.4f;
    //Dracula
    public static final float DRACULA_K = 0.2f;
    public static final float DRACULA_P = 0.3f;
    public static final float DRACULA_R = 0.1f;
    public static final float DRACULA_W = 0.4f;
    public static final int DRACULA_KNIGHT_DMG = 60;
    public static final int DRACULA_PYRO_DMG = 40;
    public static final int DRACULA_WIZARD_DMG = 20;
    public static final int DRACULA_ROGUE_DMG = 35;
    //GoodBoy
    public static final float GOODBOY_K = 0.4f;
    public static final float GOODBOY_P = 0.5f;
    public static final float GOODBOY_R = 0.4f;
    public static final float GOODBOY_W = 0.3f;
    public static final int GOODBOY_KNIGHT_HEAL = 20;
    public static final int GOODBOY_PYRO_HEAL = 30;
    public static final int GOODBOY_ROGUE_HEAL = 40;
    public static final int GOODBOY_WIZARD_HEAL = 50;
    //SmallAngel
    public static final float SMALLANGEL_K = 0.1f;
    public static final float SMALLANGEL_P = 0.15f;
    public static final float SMALLANGEL_R = 0.05f;
    public static final float SMALLANGEL_W = 0.1f;
    public static final int SMALLANGEL_KNIGHT_HEAL = 10;
    public static final int SMALLANGEL_PYRO_HEAL = 15;
    public static final int SMALLANGEL_ROGUE_HEAL = 20;
    public static final int SMALLANGEL_WIZARD_HEAL = 25;
    //Strategy
    public static final float AGGRESSIVE_K = 0.5f;
    public static final float AGGRESSIVE_P = 0.7f;
    public static final float AGGRESSIVE_R = 0.4f;
    public static final float AGGRESSIVE_W = 0.6f;
    public static final float DEFENSIVE_K = 0.2f;
    public static final float DEFENSIVE_P = 0.3f;
    public static final float DEFENSIVE_R = 0.1f;
    public static final float DEFENSIVE_W = 0.2f;
    //Strategy HP constants
    public static final int LIFE_KNIGHT_AGGR = 5;
    public static final int LIFE_PYRO_AGGR = 4;
    public static final int LIFE_WIZARD_AGGR = 10;
    public static final int LIFE_ROGUE_AGGR = 7;
    public static final int LIFE_KNIGHT_DEF = 4;
    public static final int LIFE_PYRO_DEF = 3;
    public static final int LIFE_WIZARD_DEF = 5;
    public static final int LIFE_ROGUE_DEF = 2;
    //Max HP Strategy constants
    public static final int STRATEGY_K_1 = 3;
    public static final int STRATEGY_K_2 = 2;
    public static final int STRATEGY_P_1 = 4;
    public static final int STRATEGY_P_2 = 3;
    public static final int STRATEGY_R_1 = 7;
    public static final int STRATEGY_R_2 = 5;
    public static final int STRATEGY_W_1 = 4;
    public static final int STRATEGY_W_2 = 2;
    // level up angel
    public static final float LEVEL_ANGEL_K = 0.1f;
    public static final float LEVEL_ANGEL_P = 0.2f;
    public static final float LEVEL_ANGEL_R = 0.15f;
    public static final float LEVEL_ANGEL_W = 0.25f;

    // input
    public static final int INPUT_HELPER = 5;
}
