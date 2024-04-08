CREATE DATABASE DB_SalesMotorcycle
GO


GO

-- Customers Table
CREATE TABLE Customers (
    CustomerID INT IDENTITY(1,1) PRIMARY KEY,
    DNI CHAR(8),
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Address VARCHAR(100),
    Phone VARCHAR(20)
);

-- Motorcycle Types Table
CREATE TABLE MotorcycleTypes (
    MotorcycleTypeID INT IDENTITY(1,1) PRIMARY KEY,
    Name VARCHAR(50)    
);

-- Brands Table
CREATE TABLE Brands (
    BrandID INT IDENTITY(1,1) PRIMARY KEY,
    Name VARCHAR(50),    
);

-- Products Table
CREATE TABLE Products (
    ProductID INT IDENTITY(1,1) PRIMARY KEY,
    Name VARCHAR(50),
    Displacement VARCHAR(50), 
    Price DECIMAL(10, 2),
    StockQuantity INT,
    MotorcycleTypeID INT,
    BrandID INT,    
    FOREIGN KEY (MotorcycleTypeID) REFERENCES MotorcycleTypes(MotorcycleTypeID),
    FOREIGN KEY (BrandID) REFERENCES Brands(BrandID)
);

-- Sales Table
CREATE TABLE Sales (
    SaleID INT IDENTITY(1,1) PRIMARY KEY,
    CustomerID INT,
    ProductID INT,
    Date DATETIME,
    Quantity INT,
    TotalPrice DECIMAL(10, 2),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- Sales Details Table
CREATE TABLE SalesDetails (
    DetailID INT IDENTITY(1,1) PRIMARY KEY,
    SaleID INT,
    Quantity INT,
    Price DECIMAL(10, 2),
    FOREIGN KEY (SaleID) REFERENCES Sales(SaleID),
);
