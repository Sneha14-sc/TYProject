/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gcb;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Sneha
 */
public class database1 {

    public static TableModel rst(ResultSet rs)
    {
    try
    {
        ResultSetMetaData md=rs.getMetaData();
        int noc=md.getColumnCount();
    Vector cN=new Vector();
    for(int c=0;c<noc;c++)
    { 
   cN.addElement(md.getColumnLabel(c+1));
    }
    Vector rows=new Vector();
    while(rs.next())
    {
        Vector nr=new Vector();
        for(int i=0;i<=noc;i++)
        {
        nr.addElement(rs.getObject(i));
        }
    rows.addElement(nr);
    }
    return new DefaultTableModel(rows,cN);
    }
    catch(Exception e)
    {
        e.printStackTrace();
        return null;
    }
    }
  /*  public static void main(STring arg[])
    {
    }*/
}
