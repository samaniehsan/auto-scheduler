package org.txstate.auto_scheduler;

public class StudentInfoRepositoryImpl implements StudentInfoRepository{
	ResourcePathProvider pathProvider;
	public StudentInfoRepositoryImpl(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	public StudentInfo getInfo(String studentId) {
		String recordsFolderRelativePath = this.pathProvider.getRecords();
		throw new UnsupportedOperationException("Implement by reading from json");
	}
}
