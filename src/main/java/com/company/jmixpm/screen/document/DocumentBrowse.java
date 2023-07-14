package com.company.jmixpm.screen.document;

import com.company.jmixpm.entity.Document;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Document.browse")
@UiDescriptor("document-browse.xml")
@LookupComponent("documentsTable")
public class DocumentBrowse extends StandardLookup<Document> {
    /*@Autowired
    private UnconstrainedDataManager unconstrainedDataManager;

    @Install(to = "documentsDl", target = Target.DATA_LOADER)
    private List<Document> documentsDlLoadDelegate(LoadContext<Document> loadContext) {
        return unconstrainedDataManager.loadList(loadContext);
    }*/
}