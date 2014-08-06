/*
 * Point_r.h
 *
 *  Created on: 06/ago/2014
 *      Author: dmike
 */

#ifndef POINT_R_H_
#define POINT_R_H_

struct Point {
	const char _ [sizeof(struct{
		const void *class;
		int x,y;
	})];
};

#endif /* POINT_R_H_ */
