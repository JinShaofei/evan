package cola.ds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import cola.ds.holder.DynamicDataSourceHolder;

/**
 * 
 * @author shaofeijin
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSouce();
    }
}
