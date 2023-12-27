package Data.Repositories;

import Data.Models.MyContactList;

public interface MyContactListRepository {

    MyContactList save(MyContactList contact);
    MyContactList delete(MyContactList contact);
    MyContactList findById(int id);
    void clear();
    Iterable<MyContactList> findAll();
    long count();
}
