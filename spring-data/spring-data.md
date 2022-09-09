# Spring Data
- Spring Data 是 Spring 的一个子项目。用于简化数据库访问，支持 NoSQL 和关系数据存储。其主要目标是使数据库的访问变得方便快捷。
---
## 支持的 NoSQL
1. MongoDB (文档数据库)
2. Neo4j (图形数据库)
3. Redis (键/值存储)
4. Hbase （列族数据库)
---
## 支持的关系数据存储技术
1. JDBC
2. JPA
---
# Spring Data JPA
- Spring Data JPA 致力于减少数据访问层(DAO)的开发量，开发者唯一要做的，就只是声明持久层的接口，其它都交给 Spring Data JPA 来完成。
---
## Spring Data JPA 持久层开发步骤
1. 配置 Spring 整合 JPA
2. 在 Spring 配置文件中配置 Spring Data
3. 声明持久层接口，该接口继承 Repository
4. 在接口中声明需要的方法
---
## Repository
1. Repository 是一个空接口，即是一个标记接口
2. 若我们定义的接口继承了 Repository，则该接口会被 IOC 容器标识为一个 Repository Bean，纳入到 IOC 容器中。进而可以在该接口中定义满足一定规范的方法
3. 也可以通过 @RepositoryDefinition 注解来替代继承 Repository 接口
### Repository 子接口
```
1. CrudRepository:                继承 Repository，实现了一组 CRUD 相关的方法
2. PagingAndSortingRepository:    继承 CrudRepository，实现了一组分页排序相关的方法
3. JpaRepository:                 继承 PagingAndSortingRepository，实现了一组 JPA 规范相关的方法。
4. JpsSpecificationExecutor:      不属于 Repository 体系，实现了一组 JPA Criteria 查询相关的方法

ps: 自定义 XxxRepository 一般继承 JpaRepository 和 JpsSpecificationExecutor
```
### Repository 子接口方法定义规范
```
1. 查询方法以 find | read | get 开头
2. 涉及条件查询时，条件的属性用条件关键字连接
3. 支持级联查询
4. 支持属性的级联查询，若当前类有符合条件的属性，则优先使用，而不使用级联属性。
   若需要使用级联属性，则属性之间使用_进行连接
```
### 支持关键字
```
And             Or              Between             LessThan            GreaterThan     
After           Before          IsNull              IsNotNull           NotNull         
Like            NotLike         StartingWith        Ending`W`ith        Containing
OrderBy         Not             In                  NotIn               TRUE                FALSE
```
---
## @Query
- 使用 @Query 注解可以自定义 JPQL 语句以实现更灵活的查询
### 传递参数
```
1. 使用占位符    @Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% OR p.email Like ?2")
                SpringData 允许在 JPQL 语句上添加 %
2. 命名参数     @Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
                testQuery(@Param("email") String email, @Param("lastName") String lastName);
```
---
## @Modifying
- 同时使用 @Modifying 和 @Query 注解，可以自定义更新操作 (UPDATE/DELETE)
    + 方法返回值应该为 int，表示更新语句所影响的行数
    + 在调用的地方必须添加事务，没有事务不能正常执行
```
@Modifying
@Query("UPDATE Person p SET p.email = :email WHERE id = :id")
```
---
## Repository 添加自定义方法
1. 单个 Repository
```
1. 定义一个接口：声明要添加的方法
2. 提供该接口的实现类：类名需在要声明的 Repository 后添加 Impl，并实现方法
3. 声明 Repository 接口，并实现 1. 的接口

ps: 默认情况下，SpringData 会在 base-package 中查找 "xxxImpl" 作为实现类
    也可以通过 repository-impl-postfix 声明后缀
```
2. [所有 Repository](https://blog.csdn.net/saafdgvsdg/article/details/80603581)
---
