select o from Orders o join Customers c on c.id=o.customer where c.name= :name