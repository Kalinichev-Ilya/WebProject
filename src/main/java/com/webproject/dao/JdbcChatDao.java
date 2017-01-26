package com.webproject.dao;

import com.webproject.entity.Chat;
import com.webproject.exceptions.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//TODO Дописать реализации
public class JdbcChatDao implements GenericDao<Chat, Integer> {

    /**
     * Создает новый Чат согласно соответсвующему объекту
     */
    @Override
    public String create(Chat chat) throws PersistException {//TODO Подумать над ошибками
        List<String> userIdList = chat.getMembersIdList();
        StringBuffer buffUserId = new StringBuffer("");
        if (userIdList.size() > 1) {
            for (String id : userIdList) {
                buffUserId = new StringBuffer(buffUserId + "/" + id);
            }
        } else buffUserId.append(userIdList.get(0));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(new Date());

        String insertSql =
                "INSERT INTO CHATS(date_creation, members_id) VALUES ("
                        + date + "," + buffUserId + ")";
        return insertSql;
    }

    /**
     * Возвращает Чат соответствующий записи с первичным ключом key или null
     */
    @Override
    public Chat getByID(Integer key, Connection conn) throws PersistException {

        int id = 0;
        String date = "";
        String membersLine = "";

        String chatID = "SELECT ID, date_creation, members_id FROM CHATS WHERE ID = " + key;
        try (PreparedStatement statement = conn.prepareStatement(chatID)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("ID");
                date = resultSet.getString("date_creation");
                membersLine = resultSet.getString("members_id");
            }
        } catch (SQLException e) {//TODO или лучше throw new PersistException("ChatID not exist.");
            System.out.println("ChatID not exist.");
            e.printStackTrace();
        }
        List<String> members = Arrays.asList(membersLine.split("/"));

        return new Chat(id, date, members);
    }

    /**
     * Сохраняет состояние объекта Чата в базе данных
     */
    @Override
    public void update(Chat object, Connection conn) throws PersistException {

    }

    /**
     * Удаляет запись об объекте Чата из базы данных
     */
    @Override
    public void delete(Chat object, Connection conn) throws PersistException {

    }

    /**
     * Возвращает список всех Чатов соответствующих всем записям в базе данных
     */
    @Override
    public List<Chat> getAll(Connection conn) throws PersistException {
        return null;
    }
}
