package pixlepix.carts.lexicon;

import pixlepix.carts.lexicon.page.PageTutorial;

/**
 * Created by localmacaccount on 6/2/15.
 */
public class TLexiconEntry extends BLexiconEntry {

    public TLexiconEntry() {
        super("tutorial", CategoryManager.categoryBasics);
        setPriority();
        setLexiconPages(new PageTutorial("0"));
    }


}