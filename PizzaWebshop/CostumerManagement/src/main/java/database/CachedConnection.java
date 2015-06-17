package database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author
 */
public class CachedConnection
{

    private Queue<Statement> statQueue = new LinkedList<Statement>();
    private Connection con = null;

    public CachedConnection(Connection con)
    {
        this.con = con;
    }

    public Statement getStatement() throws Exception
    {

        if (con == null)
        {
            throw new Exception("not connected");
        }
        if (!statQueue.isEmpty())
        {
            return statQueue.poll();
        }

        return con.createStatement();
    }

    public void releaseStatement(Statement stat) throws Exception
    {

        if (con == null)
        {
            throw new Exception("not connected");
        }
        statQueue.offer(stat);
    }
}
