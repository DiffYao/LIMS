package com.laoxu.java.bookman.framework;

import com.laoxu.java.bookman.framework.pagination.PaginationRowBounds;
import com.laoxu.java.bookman.framework.pagination.PagingResult;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * SqlSessionTemplate封装
 *
 * @author laoxu
 * @create 2018-10-23
 *
 **/
public class AbstractService {
    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <T> T selectOne( String statement )
    {
        return template.selectOne( statement ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <T> T selectOne( String statement, Object parameter )
    {
        return template.selectOne( statement, parameter ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <E> List<E> selectList( String statement )
    {
        return template.selectList( statement ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <E> List<E> selectList( String statement, Object parameter )
    {
        return template.selectList( statement, parameter ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <E> List<E> selectList( String statement, Object parameter, RowBounds rowBounds )
    {
        return template.selectList( statement, parameter, rowBounds ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <E> PagingResult<E> selectPaging( String statement, Object parameter, String sortField, String sort, int currentPage, int pageSize )
    {
        int offset = ( currentPage - 1 ) * pageSize ;
        int limit = pageSize ;
        PaginationRowBounds rowBounds = new PaginationRowBounds( offset, limit, sortField, sort ) ;
        List<E> rows = selectList( statement, parameter, rowBounds ) ;
        int records = rows.size();
        PagingResult<E> dataPaging = new PagingResult<E>( rows, currentPage, pageSize, records ) ;
        return dataPaging ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <E> PagingResult<E> selectComplexPaging( String statement, Object parameter, String sortFieldOne, String sortOne, String sortFieldTwo, String sortTwo, int currentPage, int pageSize )
    {
        int offset = ( currentPage - 1 ) * pageSize ;
        int limit = pageSize ;
        PaginationRowBounds rowBounds = new PaginationRowBounds( offset, limit, sortFieldOne, sortOne, sortFieldTwo,sortTwo) ;
        List<E> rows = selectList( statement, parameter, rowBounds ) ;
        int records = rows.size() ;
        PagingResult<E> dataPaging = new PagingResult<E>( rows, currentPage, pageSize, records ) ;
        return dataPaging ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <K,V> Map<K,V> selectMap( String statement, String mapKey )
    {
        return template.selectMap( statement, mapKey ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <K,V> Map<K,V> selectMap( String statement, Object parameter, String mapKey )
    {
        return template.selectMap( statement, parameter, mapKey ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected <K,V> Map<K,V> selectMap( String statement, Object parameter, String mapKey, RowBounds rowBounds )
    {
        return template.selectMap( statement, parameter, mapKey, rowBounds ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected void select( String statement, Object parameter, ResultHandler handler )
    {
        template.select( statement, parameter, handler ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected void select( String statement, ResultHandler handler )
    {
        template.select( statement, handler ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler )
    {
        template.select( statement, parameter, rowBounds, handler ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected int insert( String statement )
    {
        return template.insert( statement ) ;
    }

    @SuppressWarnings( "unchecked" )
    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected int insert( String statement, Object parameter )
    {
        int exceRowCount = 0 ;
        if( parameter instanceof Map<?,?> )
        {
            Map<String,Object> map = (Map<String,Object>)parameter ;
            for( Map.Entry<String,Object> entry : map.entrySet() )
            {
                String key = entry.getKey() ;
                Object value = entry.getValue() ;
                if( value instanceof List<?> )
                {
                    List<?> list = (List<?>)value ;
                    if( list != null && !list.isEmpty() )
                    {
                        Object entity = list.get( 0 ) ;
                        int fieldNums = 0 ;
                        if( entity instanceof Map )
                            fieldNums = ( (Map<String,Object>)entity ).size() ;
                        else
                            fieldNums = entity.getClass().getDeclaredFields().length + 5 ;
                        int count = PARAMETER_COUNT / fieldNums ;
                        int i = 0 ;
                        boolean flag = true ;
                        while( flag )
                        {
                            i++ ;
                            int startIndex = ( i - 1 ) * count ;
                            int endIndex = i * count ;
                            if( endIndex >= list.size() )
                            {
                                endIndex = list.size() ;
                                flag = false ;
                            }
                            List<?> result = list.subList( startIndex, endIndex ) ;
                            map.put( key, result ) ;
                            exceRowCount += template.insert( statement, map ) ;
                        }
                    }
                }
                else
                {
                    exceRowCount += template.insert( statement, parameter ) ;
                    break ;
                }
            }
        }
        else if( parameter instanceof List<?> )
        {
            List<?> list = (List<?>)parameter ;
            if( list != null && !list.isEmpty() )
            {
                Object entity = list.get( 0 ) ;
                int fieldNums = 0 ;
                if( entity instanceof Map )
                    fieldNums = ( (Map<String,Object>)entity ).size() ;
                else
                    fieldNums = entity.getClass().getDeclaredFields().length ;
                int count = PARAMETER_COUNT / fieldNums ;
                int i = 0 ;
                boolean flag = true ;
                while( flag )
                {
                    i++ ;
                    int startIndex = ( i - 1 ) * count ;
                    int endIndex = i * count ;
                    if( endIndex >= list.size() )
                    {
                        endIndex = list.size() ;
                        flag = false ;
                    }
                    List<?> result = list.subList( startIndex, endIndex ) ;
                    exceRowCount += template.insert( statement, result ) ;
                }
            }
        }
        else
        {
            exceRowCount += template.insert( statement, parameter ) ;
        }
        return exceRowCount ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected int update( String statement )
    {
        return template.update( statement ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected int update( String statement, Object parameter )
    {
        return template.update( statement, parameter ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected int delete( String statement )
    {
        return template.delete( statement ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected int delete( String statement, Object parameter )
    {
        return template.delete( statement, parameter ) ;
    }

    @Transactional( propagation = Propagation.NESTED, rollbackFor = { Throwable.class } )
    protected int updateWithOutOperator( String statement, Object parameter )
    {
        return template.update( statement, parameter ) ;
    }


    private static final int PARAMETER_COUNT = 2100 ;

    @Autowired
    private SqlSessionTemplate template ;
}
