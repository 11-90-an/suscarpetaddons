package susaddons;

import carpet.settings.Rule;
import static carpet.settings.RuleCategory.*;

public class SusAddonsSettings
{
    public static final String SUS = "sus";

    @Rule (
        desc = "Comparators can read through pistons and chains",
        category = {FEATURE, SUS},
        options = {"false", "true"}
    )
    public static boolean comparatorReadThroughOthers = false;

    @Rule (
        desc = "Adjustable item despawn time",
        category = {FEATURE, SUS},
        options = {"6000", "12000"},
        strict = false
    )
    public static int itemDespawnTimeLength = 6000;

    @Rule (
        desc = "Redstone dust, redstone torches, repeaters and comparators can be moved now",
        category = {FEATURE, SUS},
        options = {"false", "true"}
    )
    public static boolean movableRedstoneStuff = false;
}