package com.gigaspaces.gigapro;

import com.j_spaces.core.IJSpace;
import com.j_spaces.core.SpaceContext;
import com.j_spaces.core.filters.ISpaceFilter;
import com.j_spaces.core.filters.entry.ISpaceFilterEntry;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Svitlana_Pogrebna
 *
 */
public class SpaceWriteTpFilter implements ISpaceFilter {

    @Autowired
    private SpaceWriteTpStatistics spaceWriteTpStatistics;
    
    @Override
    public void init(IJSpace iJSpace, String filterId, String url, int paramInt) {
    }

    @Override
    public void process(SpaceContext context, ISpaceFilterEntry entry, int operationCode) {
        switch (operationCode) {
        case 1: // AfterWrite
            spaceWriteTpStatistics.incrementWriteCounter();
            break;
        default:
            throw new UnsupportedOperationException("operation " + operationCode + " is not supported");
        }
    }

    @Override
    public void process(SpaceContext context, ISpaceFilterEntry[] entries, int operationCode) {
        throw new UnsupportedOperationException("multiple entries filter operations are not supported");
    }

    @Override
    public void close() {}

}
