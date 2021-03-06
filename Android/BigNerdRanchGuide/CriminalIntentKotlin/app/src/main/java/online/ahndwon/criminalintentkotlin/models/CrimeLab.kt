package online.ahndwon.criminalintentkotlin.models

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Environment
import online.ahndwon.criminalintentkotlin.database.CrimeBaseHelper
import online.ahndwon.criminalintentkotlin.database.CrimeCursorWrapper
import online.ahndwon.criminalintentkotlin.database.CrimeDbSchema.Companion.CrimeTable
import online.ahndwon.criminalintentkotlin.database.CrimeDbSchema.Companion.Cols
import java.io.File
import java.io.FileNotFoundException
import java.util.*


object CrimeLab {
    val crimes = ArrayList<Crime>()
    var database: SQLiteDatabase? = null


    //    val crimes = ArrayList<Crime>().apply {
//        for (i in 0..99) {
//            val crime = Crime()
//            crime.mTitle = "범죄 #$i"
//            crime.setmSolved(i % 2 == 0)
//            add(crime)
//        }
//    }

//    val crimes = ArrayList<Crime>()

    fun getContentValues(crime: Crime): ContentValues {
        val values = ContentValues()
        values.put(Cols.UUID, crime.mId.toString())
        values.put(Cols.TITLE, crime.mTitle)
        values.put(Cols.DATE, crime.mDate.time)
        values.put(Cols.SOLVED, if (crime.ismSolved()) 1 else 0)
        values.put(Cols.SUSPECT, crime.suspect)

        return values
    }

    fun getDatabase(context: Context): SQLiteDatabase? {
        return if (database != null) {
            database = CrimeBaseHelper(context).writableDatabase
            database
        } else {
            database
        }
    }

    fun addCrime(context: Context, crime: Crime) {
        val values = getContentValues(crime)
        database?.insert(CrimeTable.NAME, null, values)
    }

    fun updateCrime(crime: Crime) {
        val uuidString = crime.mId.toString()
        val values = getContentValues(crime)

        database?.update(CrimeTable.NAME, values,
            Cols.UUID + " = ?",
            Array<String>(1) { uuidString })
    }

    fun queryCrimes(whereClause: String, whereArgs: Array<String>): Cursor? {
        val cursor = database?.query(
            CrimeTable.NAME,
            null,
            whereClause,
            whereArgs,
            null,
            null,
            null
        )
        cursor?.close()
        cursor?.let {
            return CrimeCursorWrapper(it)
        }
        return null

    }

    fun getCrime(id: UUID) : Crime? {
        val cursor = queryCrimes(Cols.UUID + " = ?",
            Array (1){ id.toString()}) as CrimeCursorWrapper

        cursor.use { c ->
            c.let {
                if (c.count == 0) {
                    return null
                }

                c.moveToFirst()
                return c.getCrime()
            }
        }
    }

    fun getPhotoFile(context: Context, crime: Crime): File? {
        val externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                ?: return null

        return File(externalFilesDir, crime.getPhotoFileName())
    }
}
