package org.telegram.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import org.telegram.dao.MediaRecord;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MEDIA_RECORD.
*/
public class MediaRecordDao extends AbstractDao<MediaRecord, Long> {

    public static final String TABLENAME = "MEDIA_RECORD";

    /**
     * Properties of entity MediaRecord.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Mid = new Property(1, Integer.class, "mid", false, "MID");
        public final static Property PeerUniq = new Property(2, long.class, "peerUniq", false, "PEER_UNIQ");
        public final static Property Date = new Property(3, int.class, "date", false, "DATE");
        public final static Property SenderId = new Property(4, int.class, "senderId", false, "SENDER_ID");
        public final static Property Preview = new Property(5, byte[].class, "preview", false, "PREVIEW");
    };


    public MediaRecordDao(DaoConfig config) {
        super(config);
    }
    
    public MediaRecordDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MEDIA_RECORD' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'MID' INTEGER," + // 1: mid
                "'PEER_UNIQ' INTEGER NOT NULL ," + // 2: peerUniq
                "'DATE' INTEGER NOT NULL ," + // 3: date
                "'SENDER_ID' INTEGER NOT NULL ," + // 4: senderId
                "'PREVIEW' BLOB NOT NULL );"); // 5: preview
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_MEDIA_RECORD_MID ON MEDIA_RECORD" +
                " (MID);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_MEDIA_RECORD_PEER_UNIQ_DATE ON MEDIA_RECORD" +
                " (PEER_UNIQ,DATE);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MEDIA_RECORD'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MediaRecord entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer mid = entity.getMid();
        if (mid != null) {
            stmt.bindLong(2, mid);
        }
        stmt.bindLong(3, entity.getPeerUniq());
        stmt.bindLong(4, entity.getDate());
        stmt.bindLong(5, entity.getSenderId());
        stmt.bindBlob(6, entity.getPreview());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public MediaRecord readEntity(Cursor cursor, int offset) {
        MediaRecord entity = new MediaRecord( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // mid
            cursor.getLong(offset + 2), // peerUniq
            cursor.getInt(offset + 3), // date
            cursor.getInt(offset + 4), // senderId
            cursor.getBlob(offset + 5) // preview
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MediaRecord entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMid(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setPeerUniq(cursor.getLong(offset + 2));
        entity.setDate(cursor.getInt(offset + 3));
        entity.setSenderId(cursor.getInt(offset + 4));
        entity.setPreview(cursor.getBlob(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MediaRecord entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MediaRecord entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}