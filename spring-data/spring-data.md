# Spring Data
Spring Data 是 Sping 的一个子项目。用于简化数据库访问，支持 NoSQL 和关系数据存储。其主要目标是使数据库的访问变得方便快捷。
>---
>## 支持的 NoSQL
>1. MongoDB (文档数据库)
>2. Neo4j (图形数据库)
>3. Redis (键/值存储)
>4. Hbase （列族数据库)
>---
>## 支持的关系数据存储技术
>1. JDBC
>2. JPA
---
# Spring Data JPA
Spring Data JPA 致力于减少数据访问层(DAO)的开发量，开发者唯一要做的，就只是声明持久层的接口，其它都交给 Spring Data JPA 来完成。
---
>## Spring Data JPA 持久层开发步骤
>1. 配置 Spring 整合 JPA
>2. 在 Spring 配置文件中配置 Spring Data
>3. 声明持久层接口，该接口继承 Repository
>4. 在接口中声明需要的方法
>---
>## Repository
>1. Repository 是一个空接口，即是一个标记接口
>2. 若我们定义的接口继承了 Repository，则该接口会被 IOC 容器标识为一个 Repository Bean，纳入到 IOC 容器中。进而可以在该接口中定义满足一定规范的方法
>3. 也可以通过 @RepositoryDefinition 注解来替代继承 Repository 接口
>>### Repository 子接口
>>```
>>1. CrudRepository:                继承 Repository，实现了一组 CRUD 相关的方法
>>2. PagingAndSortingRepository:    继承 CrudRepository，实现了一组分页排序相关的方法
>>3. JpaRepository:                 继承 PagingAndSortingRepository，实现了一组 JPA 规范相关的方法。
>>                                  自定义 XxxRepository 需要继承 JpaRepository。
>>4. JpsSpecificationExecutor:      不属于 Repository 体系，实现了一组 JPA Criteria 查询相关的方法
>>```
---